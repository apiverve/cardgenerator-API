Card Generator API
============

Card Generator is a simple tool for generating test/sample card numbers. It returns a list of card numbers for testing.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)

This is a Javascript Wrapper for the [Card Generator API](https://apiverve.com/marketplace/api/cardgenerator)

---

## Installation
	npm install @apiverve/cardgenerator --save

---

## Configuration

Before using the cardgenerator API client, you have to setup your account and obtain your API Key.  
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Usage

The Card Generator API documentation is found here: [https://docs.apiverve.com/api/cardgenerator](https://docs.apiverve.com/api/cardgenerator).  
You can find parameters, example responses, and status codes documented here.

### Setup

```
var cardgeneratorAPI = require('@apiverve/cardgenerator');
var api = new cardgeneratorAPI({
    api_key: [YOUR_API_KEY],
    secure: true //(Optional, defaults to true)
});
```

---


### Perform Request
Using the API client, you can perform requests to the API.

###### Define Query

```
var query = {
  brand: "visa",
  count: 5
};
```

###### Simple Request (using Callback)

```
api.execute(query, function (error, data) {
    if (error) {
        return console.error(error);
    } else {
        console.log(data);
    }
});
```

###### Example Response

```
{
  "status": "ok",
  "error": null,
  "data": {
    "brand": "visa",
    "count": 5,
    "cards": [
      {
        "cvv": 157,
        "issuer": "BANCORP BANK",
        "number": "4267563564424775",
        "expiration": "2029-05-13T03:31:14.312Z",
        "brand": "visa",
        "number_alt": "4267 5635 6442 4775"
      },
      {
        "cvv": 701,
        "issuer": "ALTIER C.U.",
        "number": "4756354919210087",
        "expiration": "2029-05-13T03:31:14.315Z",
        "brand": "visa",
        "number_alt": "4756 3549 1921 0087"
      },
      {
        "cvv": 909,
        "issuer": "UNION BANK OF THE PHILIPPINES",
        "number": "4588247072155889",
        "expiration": "2029-05-13T03:31:14.318Z",
        "brand": "visa",
        "number_alt": "4588 2470 7215 5889"
      },
      {
        "cvv": 746,
        "issuer": "WELLS FARGO BANK, N.A.",
        "number": "4269604751957306",
        "expiration": "2029-05-13T03:31:14.32Z",
        "brand": "visa",
        "number_alt": "4269 6047 5195 7306"
      },
      {
        "cvv": 959,
        "issuer": "RAIFFEISENBANK (BULGARIA) EAD",
        "number": "4321781342457214",
        "expiration": "2029-05-13T03:31:14.322Z",
        "brand": "visa",
        "number_alt": "4321 7813 4245 7214"
      }
    ],
    "owner": {
      "name": "Walter Tillman",
      "address": {
        "street": "5280 Hartmann Plaza",
        "city": "East Feliciaberg",
        "state": "New Hampshire",
        "zipCode": "88590"
      }
    }
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the mailboxlayer website, API, and services is subject to the [APIVerve Terms & Conditions](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2024 APIVerve, and Evlar LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.