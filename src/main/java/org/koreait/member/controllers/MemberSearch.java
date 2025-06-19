package org.koreait.member.controllers;

import lombok.Data;
import org.koreait.global.search.CommonSeacrch;
import org.koreait.member.constants.Authority;

import java.util.List;

@Data
public class MemberSearch extends CommonSeacrch {
    private List<Authority> authority;
}
