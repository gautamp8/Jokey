# Screenshots
<img src="https://s19.postimg.org/azv9j7bk3/14971697_1161402473936511_634571318_o.jpg" height = '550' width="300" margin="100">
<img src="https://s19.postimg.org/bqnzozdxf/14963503_1161402460603179_2107485400_o.jpg" height = '550' width="300">

# Gradle for Android and Java Final Project

This app with multiple flavors uses
multiple libraries and Google Cloud Endpoints. The finished app consists
of four modules. A Java library that provides jokes, a Google Cloud Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## Why this Project

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

##What did I Learnt?

* Role of Gradle in building Android Apps and how to use Gradle to manage apps of increasing complexity.
* Add free and paid flavors to an app, and set up your build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configure a multi project build to compile your libraries and app
* Use the Gradle App Engine plugin to deploy a backend
* Configure an integration test suite that runs against the local App Engine development server

