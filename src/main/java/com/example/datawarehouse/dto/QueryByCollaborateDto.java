package com.example.datawarehouse.dto;

import lombok.Data;

@Data
public class QueryByCollaborateDto {

    private Role role1;

    private Role role2;

    private String name;

    private Integer limit;

    public QueryByCollaborateDto(String relation, String name, Integer limit) {
        setRoles(relation);
        setName(name);
        setLimit(limit);
    }

    public void setRoles(String relation) {
        String[] rolesStr = relation.split("-");
        if (rolesStr[0].equals("a")) {
            setRole1(Role.ACTOR);
        } else {
            setRole1(Role.DIRECTOR);
        }

        if (rolesStr[1].equals("a")) {
            setRole2(Role.ACTOR);
        } else {
            setRole2(Role.DIRECTOR);
        }
    }
}

