# CartControllerApi

All URIs are relative to *http://localhost:8080*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getCart**](CartControllerApi.md#getCart) | **GET** /v1/cart | get the cart |
| [**submitProduct**](CartControllerApi.md#submitProduct) | **POST** /v1/cart | update an item |


<a name="getCart"></a>
# **getCart**
> String getCart()

get the cart

    get a map with all the items in a cart

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

<a name="submitProduct"></a>
# **submitProduct**
> Boolean submitProduct(CartRequest)

update an item

    add a product with name and price to the cart

### Parameters

|Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **CartRequest** | [**CartRequest**](../Models/CartRequest.md)|  | |

### Return type

**Boolean**

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

