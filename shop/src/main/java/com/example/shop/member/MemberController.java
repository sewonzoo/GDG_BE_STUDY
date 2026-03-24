package com.example.shop.member;


import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController // (@Controller + @ResponseBody)
@RequiredArgsConstructor  //final 만 필드값으로 받음
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping //HTTP POST 요청을 받는 API
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request ) {   //요청 body(JSON)을 객체로 변환  // MemberCreateRequest : DTO 객체
        Long memberId = memberService.createMember(request); //db에 저장 / 생성된 ID 변환
        return ResponseEntity.created(URI.create("/members/" + memberId)).build();  // HTTP 응답 직접 제어 (상태 코드 201 created / 헤더 : /members/{id}
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers() {
        //Service 계층에서 회원 목록을 가져온다
        List<Member>members = memberService.getAllMembers();
        return ResponseEntity.ok(members);

    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable("memberId") Long memberId) {
        Member member = memberService.getMemberById(memberId);
        return ResponseEntity.ok(member);
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> updateMember(
            @PathVariable Long memberId,
            @RequestBody MemberUpdateRequest request) {
        memberService.updateMember(memberId,request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }

}
