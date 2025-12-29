# PasswordControllerApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**validatePassword**](PasswordControllerApi.md#validatePassword) | **GET** /v1/password | ejecute a validation of a password |


<a name="validatePassword"></a>
# **validatePassword**
> Boolean validatePassword(password)

ejecute a validation of a password

    validate if a password fulfill various conditions

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **password** | **String**| password to validate | [default to null] |

### Return type

**Boolean**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

