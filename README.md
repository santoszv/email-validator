Email validator
===============

Email validator is a simple wrapper to *javax.mail.internet.InternetAddress*. The validation
is accomplished by creating an *InternetAddress* object, calling *InternetAddress.validate()* and
calling *InternetAddress.getAddress().equals()* to ensure the *value* is an *email* without *name*.

Contact and Feedback
--------------------

You can contact sending an email directly to *Santos Zatarain Vera (santoszv(at)inftel.com.mx)*,
please use as subject *Email Validator*.

License
-------

    Copyright 2016 Santos Zatarain Vera

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
