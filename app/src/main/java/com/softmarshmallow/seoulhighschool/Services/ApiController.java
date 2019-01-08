package com.softmarshmallow.seoulhighschool.Services;

import org.hyunjun.school.School;

import static com.softmarshmallow.seoulhighschool.Helpers.SchoolInfoConfig.SEOUL_HS_SCHOOL_CODE;


public class ApiController
{
        public static School schoolApi = new School(School.Type.HIGH, School.Region.SEOUL, SEOUL_HS_SCHOOL_CODE);
}
