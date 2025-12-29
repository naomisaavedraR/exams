# exams

---
title: OpenAPI definition v0
language_tabs:
  - shell: Shell
  - http: HTTP
  - javascript: JavaScript
  - ruby: Ruby
  - python: Python
  - php: PHP
  - java: Java
  - go: Go
toc_footers: []
includes: []
search: true
highlight_theme: darkula
headingLevel: 2

---

<!-- Generator: Widdershins v4.0.1 -->

<h1 id="openapi-definition">OpenAPI definition v0</h1>

> Scroll down for code samples, example requests and responses. Select a language for code samples from the tabs above or the mobile navigation menu.

Base URLs:

* <a href="http://localhost:8080">http://localhost:8080</a>

<h1 id="openapi-definition-cart-controller">Cart Controller</h1>

controller to update a cart

## getCart

<a id="opIdgetCart"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/v1/cart \
  -H 'Accept: application/json'

```

```http
GET http://localhost:8080/v1/cart HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/v1/cart',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json'
}

result = RestClient.get 'http://localhost:8080/v1/cart',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/v1/cart', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => 'application/json',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/v1/cart', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/v1/cart");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/v1/cart", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /v1/cart`

*get the cart*

get a map with all the items in a cart

> Example responses

> valid response

```json
{
  "code": 0,
  "message": "success",
  "payload": {
    "ensalada": 100,
    "taco": 100
  }
}
```

<h3 id="getcart-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success, the response is encapsulated in a response item|string|

<aside class="success">
This operation does not require authentication
</aside>

## submitProduct

<a id="opIdsubmitProduct"></a>

> Code samples

```shell
# You can also use wget
curl -X POST http://localhost:8080/v1/cart \
  -H 'Content-Type: application/json' \
  -H 'Accept: application/json'

```

```http
POST http://localhost:8080/v1/cart HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Accept: application/json

```

```javascript
const inputBody = '{
  "name": "apple",
  "price": 0
}';
const headers = {
  'Content-Type':'application/json',
  'Accept':'application/json'
};

fetch('http://localhost:8080/v1/cart',
{
  method: 'POST',
  body: inputBody,
  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Content-Type' => 'application/json',
  'Accept' => 'application/json'
}

result = RestClient.post 'http://localhost:8080/v1/cart',
  params: {
  }, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Content-Type': 'application/json',
  'Accept': 'application/json'
}

r = requests.post('http://localhost:8080/v1/cart', headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Content-Type' => 'application/json',
    'Accept' => 'application/json',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('POST','http://localhost:8080/v1/cart', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/v1/cart");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("POST");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Content-Type": []string{"application/json"},
        "Accept": []string{"application/json"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("POST", "http://localhost:8080/v1/cart", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`POST /v1/cart`

*update an item*

add a product with name and price to the cart

> Body parameter

```json
{
  "name": "apple",
  "price": 0
}
```

<h3 id="submitproduct-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|body|body|[CartRequest](#schemacartrequest)|true|none|

> Example responses

> valid response

```json
{
  "code": 0,
  "message": "success",
  "payload": true
}
```

<h3 id="submitproduct-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success, the response is encapsulated in a response item|boolean|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-thread-controller">Thread Controller</h1>

controller to manage threads

## validateThread

<a id="opIdvalidateThread"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/v1/thread?cycles=1000000 \
  -H 'Accept: application/json'

```

```http
GET http://localhost:8080/v1/thread?cycles=1000000 HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/v1/thread?cycles=1000000',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json'
}

result = RestClient.get 'http://localhost:8080/v1/thread',
  params: {
  'cycles' => 'integer(int64)'
}, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/v1/thread', params={
  'cycles': '1000000'
}, headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => 'application/json',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/v1/thread', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/v1/thread?cycles=1000000");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/v1/thread", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /v1/thread`

*ejecute two threads with opposite operations*

sum and substract n cycles of a number to the same variable.

<h3 id="validatethread-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|cycles|query|integer(int64)|true|number of cycles to do|

> Example responses

> valid response

```json
{
  "code": 0,
  "message": "success",
  "payload": 0
}
```

<h3 id="validatethread-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success, the response is encapsulated in a response item|integer|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-demo-controller">Demo Controller</h1>

controller to show the usage of swagger

## isAPlatypus

<a id="opIdisAPlatypus"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/v1/demo?request=name,perry,age,0,platypus,false,sound,brrrr \
  -H 'Accept: application/json'

```

```http
GET http://localhost:8080/v1/demo?request=name,perry,age,0,platypus,false,sound,brrrr HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/v1/demo?request=name,perry,age,0,platypus,false,sound,brrrr',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json'
}

result = RestClient.get 'http://localhost:8080/v1/demo',
  params: {
  'request' => '[DemoTO](#schemademoto)'
}, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/v1/demo', params={
  'request': {
  "name": "perry",
  "age": 0,
  "platypus": false,
  "sound": "brrrr"
}
}, headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => 'application/json',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/v1/demo', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/v1/demo?request=name,perry,age,0,platypus,false,sound,brrrr");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/v1/demo", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /v1/demo`

*get the sound of a platypus*

validate if the animal is a platypus and return the sound

<h3 id="isaplatypus-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|request|query|[DemoTO](#schemademoto)|true|none|

> Example responses

> valid response

```json
{
  "code": 0,
  "message": "success",
  "payload": {
    "age": 3,
    "name": "Perry",
    "platypus": false,
    "sound": "miau"
  }
}
```

<h3 id="isaplatypus-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success, the response is encapsulated in a response item|[DemoTO](#schemademoto)|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-count-controller">Count Controller</h1>

controller to count sentences

## countWords

<a id="opIdcountWords"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/v1/counter?sentence=hola%20ana%20banana \
  -H 'Accept: application/json'

```

```http
GET http://localhost:8080/v1/counter?sentence=hola%20ana%20banana HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/v1/counter?sentence=hola%20ana%20banana',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json'
}

result = RestClient.get 'http://localhost:8080/v1/counter',
  params: {
  'sentence' => 'string'
}, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/v1/counter', params={
  'sentence': 'hola ana banana'
}, headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => 'application/json',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/v1/counter', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/v1/counter?sentence=hola%20ana%20banana");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/v1/counter", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /v1/counter`

*count words*

count the quantity of words in a sentence

<h3 id="countwords-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|sentence|query|string|true|sentence to count words|

> Example responses

> valid response

```json
{
  "code": 0,
  "message": "success",
  "payload": 5
}
```

<h3 id="countwords-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success, the response is encapsulated in a response item|integer|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-palindrome-controller">Palindrome Controller</h1>

controller to validate a palindrome's word

## validatePalindrome

<a id="opIdvalidatePalindrome"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/v1/palindrome?word=ana \
  -H 'Accept: application/json'

```

```http
GET http://localhost:8080/v1/palindrome?word=ana HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/v1/palindrome?word=ana',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json'
}

result = RestClient.get 'http://localhost:8080/v1/palindrome',
  params: {
  'word' => 'string'
}, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/v1/palindrome', params={
  'word': 'ana'
}, headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => 'application/json',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/v1/palindrome', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/v1/palindrome?word=ana");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/v1/palindrome", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /v1/palindrome`

*ejecute a validation of a word*

validate if a word is a palindrome

<h3 id="validatepalindrome-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|word|query|string|true|word to validate|

> Example responses

> valid response

```json
{
  "code": 0,
  "message": "success",
  "payload": true
}
```

<h3 id="validatepalindrome-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success, the response is encapsulated in a response item|boolean|

<aside class="success">
This operation does not require authentication
</aside>

<h1 id="openapi-definition-password-controller">Password Controller</h1>

controller to validate a password

## validatePassword

<a id="opIdvalidatePassword"></a>

> Code samples

```shell
# You can also use wget
curl -X GET http://localhost:8080/v1/password?password=123abcABC%2A%2A%2A \
  -H 'Accept: application/json'

```

```http
GET http://localhost:8080/v1/password?password=123abcABC%2A%2A%2A HTTP/1.1
Host: localhost:8080
Accept: application/json

```

```javascript

const headers = {
  'Accept':'application/json'
};

fetch('http://localhost:8080/v1/password?password=123abcABC%2A%2A%2A',
{
  method: 'GET',

  headers: headers
})
.then(function(res) {
    return res.json();
}).then(function(body) {
    console.log(body);
});

```

```ruby
require 'rest-client'
require 'json'

headers = {
  'Accept' => 'application/json'
}

result = RestClient.get 'http://localhost:8080/v1/password',
  params: {
  'password' => 'string'
}, headers: headers

p JSON.parse(result)

```

```python
import requests
headers = {
  'Accept': 'application/json'
}

r = requests.get('http://localhost:8080/v1/password', params={
  'password': '123abcABC***'
}, headers = headers)

print(r.json())

```

```php
<?php

require 'vendor/autoload.php';

$headers = array(
    'Accept' => 'application/json',
);

$client = new \GuzzleHttp\Client();

// Define array of request body.
$request_body = array();

try {
    $response = $client->request('GET','http://localhost:8080/v1/password', array(
        'headers' => $headers,
        'json' => $request_body,
       )
    );
    print_r($response->getBody()->getContents());
 }
 catch (\GuzzleHttp\Exception\BadResponseException $e) {
    // handle exception or api errors.
    print_r($e->getMessage());
 }

 // ...

```

```java
URL obj = new URL("http://localhost:8080/v1/password?password=123abcABC%2A%2A%2A");
HttpURLConnection con = (HttpURLConnection) obj.openConnection();
con.setRequestMethod("GET");
int responseCode = con.getResponseCode();
BufferedReader in = new BufferedReader(
    new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();
while ((inputLine = in.readLine()) != null) {
    response.append(inputLine);
}
in.close();
System.out.println(response.toString());

```

```go
package main

import (
       "bytes"
       "net/http"
)

func main() {

    headers := map[string][]string{
        "Accept": []string{"application/json"},
    }

    data := bytes.NewBuffer([]byte{jsonReq})
    req, err := http.NewRequest("GET", "http://localhost:8080/v1/password", data)
    req.Header = headers

    client := &http.Client{}
    resp, err := client.Do(req)
    // ...
}

```

`GET /v1/password`

*ejecute a validation of a password*

validate if a password fulfill various conditions

<h3 id="validatepassword-parameters">Parameters</h3>

|Name|In|Type|Required|Description|
|---|---|---|---|---|
|password|query|string|true|password to validate|

> Example responses

> valid response

```json
{
  "code": 0,
  "message": "success",
  "payload": true
}
```

<h3 id="validatepassword-responses">Responses</h3>

|Status|Meaning|Description|Schema|
|---|---|---|---|
|200|[OK](https://tools.ietf.org/html/rfc7231#section-6.3.1)|success, the response is encapsulated in a response item|boolean|

<aside class="success">
This operation does not require authentication
</aside>

# Schemas

<h2 id="tocS_CartRequest">CartRequest</h2>
<!-- backwards compatibility -->
<a id="schemacartrequest"></a>
<a id="schema_CartRequest"></a>
<a id="tocScartrequest"></a>
<a id="tocscartrequest"></a>

```json
{
  "name": "apple",
  "price": 0
}

```

Request to upload a product to the cart

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|name|string|true|none|name of the product|
|price|integer(int64)|true|none|price of the product|

<h2 id="tocS_DemoTO">DemoTO</h2>
<!-- backwards compatibility -->
<a id="schemademoto"></a>
<a id="schema_DemoTO"></a>
<a id="tocSdemoto"></a>
<a id="tocsdemoto"></a>

```json
{
  "name": "perry",
  "age": 0,
  "platypus": false,
  "sound": "brrrr"
}

```

Request to validate if the animal is a platypus

### Properties

|Name|Type|Required|Restrictions|Description|
|---|---|---|---|---|
|name|string|true|none|name of the animal|
|age|integer(int64)|true|none|age of the animal|
|platypus|boolean|true|none|validate if is a platypus|
|sound|string|false|none|Sound of the animal|

