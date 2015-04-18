# angular-akka
Overview:
Template project for angular, scala, akka (with some spray also until spray will be incorporated into akka completely), war running inside jetty.  
Build with sbt and gulp, helpful tasks working like gulp serve (refreshing page when js modified) and ~container:start (compile + war + start jetty when scala class modified)
Included different resource folder for prod and dev
Requirements:
jdk 7+,nodeJS,  scala 2.11+, sbt 0.13+

Get Started

git clone https://github.com/aardelean/angular-akka.git

server command line:

sbt [-Dstage=prod]

package

~container:start

client command line (new command line):

npm install -g bower

npm install

bower install

gulp copy-bower

gulp serve

go to localhost:9000/index.html

Have fun!

