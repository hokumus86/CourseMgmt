package com.hokumus.course.model.management;

public enum ProfiteLows {
	NULL, KAR, ZARAR;

	public String toString() {
		switch (this) {
		case KAR:
			return "KAR";
		case ZARAR:
			return "ZARAR";
		default:
			return " ";
		}
	}
}
