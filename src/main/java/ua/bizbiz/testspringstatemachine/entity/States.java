package ua.bizbiz.testspringstatemachine.entity;

public enum States {
  
  AUTH, AUTH_SUCCESS_AS_ADMIN, AUTH_SUCCESS_AS_USER, AUTH_FAILED,
  LIST_USERS_WAS_SHOWN, LIST_USERS_WAS_NOT_SHOWN,
  USER_INFO_TO_CREATE_REQUESTED,
  USER_INFO_TO_UPDATE_REQUESTED,
  USER_INFO_TO_READ_REQUESTED,
  USER_INFO_TO_DELETE_REQUESTED,
  FAILED_TO_ENTER_USER_INFO,
}
