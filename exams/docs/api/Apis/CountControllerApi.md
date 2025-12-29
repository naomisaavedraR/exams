# CountControllerApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**countWords**](CountControllerApi.md#countWords) | **GET** /v1/counter | count words |


<a name="countWords"></a>
# **countWords**
> Integer countWords(sentence)

count words

    count the quantity of words in a sentence

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **sentence** | **String**| sentence to count words | [default to null] |

### Return type

**Integer**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

