# LIoT
Liferay IoT plugin

The idea behind this project is to transform liferay in a data collector exploiting its core functionalities such as message bus allowing to connect it to the major streaming technologies or queues.
The other crucial idea is to transform liferay (the control panel) in order to control a Big Data engine such Apache Spark.
From the control panel you can:
•	Insert a new connection to a broker: specifying properties such as topics, or custom properties. The available brokers are:
  o	Mqtt
  o	Kafka
•	Define a Broker Listener, a way to decide where data coming from broker must to be sent. At now the only broker listener is Message Bus. This means that at the beginning of your project you can connect liferay to a broker and receive directly on the MESSAGE BUS all data coming from it.

•	Setup Apache Spark by loading jars, schedule jobs on the fly, or schedule jobs on events or dates.

•	Use the internal API exposed by REST services to raise events (and fire spark jobs) or manage data inside the platform.

Those are few things that you can do with this plugin, but this is the starting point, we hope that with you help we can increase the functionalities and transform liferay in a IoT platform.

# Environment Setup

First of all, before we go deeper, let’s introduce which technologies we have used:

•	Liferay 6.2 ce GA 4 (updating tomcat to a version supporting web socket)
•	Mosquitto Broker
•	Apache Kafka 0.8.2.1
•	Apache spark 1.3.1 built for Hadoop 2.4
•	Apache spark job server 0.5.2

The first two technologies are the brokers, the second one is Spark with a Job Server that allows to control it by invoking some rest services.
Keep track of all technical info (addresses and port) of spark and brokers because we will put them later inside liferay configuration.

# Installation

The LIoT plugin comes with 2 portlet projects and 1 plugin ext:

•	LIoT-ext: is very simple, its scope is to add a new section inside the control panel called “IoT”

•	ApacheSparkManager-portlet: is the portlet that interacts with Apache Spark Job Server

•	LioT-Broker: is the portlet in which you can define brokers and how to dispatch messages.

If you deploy all plugins at once, and after the deploy receive some exceptions please restart liferay.

This project requires, for some functionalities (broker log), websocket libs, so if your container doesn’t support websockets please update it or install a new container supporting them. Nevertheless, this is an important feature you can still run the plugin without web sockets support, some real-time functionalities such as: broker real-time view will not work.

# More Info
Please refer to the manual or tutorial video or If you need more support please contact me at: aristide.cittadino@acsoftware.it


