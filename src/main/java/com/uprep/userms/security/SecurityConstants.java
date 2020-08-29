package com.uprep.userms.security;

public class SecurityConstants {
	public static final String SIGN_UP_URLS = "/user/**";
	public static final String GET_URLS = "/get/**";
	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final String TOKEN_PREFIX = "Bearer";
	public static final String HEADER_STRING = "VikaspediaAuth";
	public static final long EXPIRATION_TIME = 86400000;
	public static final long forgottoken_EXPIRATION_TIME = 86400000;
}
