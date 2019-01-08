package com.softmarshmallow.seoulhighschool.Models.TimeTable;

public enum DayType
{
        Monday(1),
        Tuesday(2),
        Wednesday(3),
        Thursday(4),
        Friday(5),
        Saturday(6),
        Sunday(7);
        
        
        
        
        int value;
        DayType(int value) {
                this.value = value;
        }
        
        public int getValue() {
                return value;
        }
        
        public static DayType getEnum(int value) {
                for (DayType e : DayType.values()) {
                        if (e.getValue() == value)
                                return e;
                }
                return null;
        }
}
