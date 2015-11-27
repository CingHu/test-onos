1. Rebuild and restart ONOS.
$ source onosrc
$ cd ${ONOS_ROOT}
$ mvn clean install
$ karaf clean


feature:install onos-gui
feature:install onos-app-ifwd
intents -i
paths
intents
apps
feature:install onos-app-ifwd
feature:uninstall onos-app-ifwd
remove-intent -p org.onosproject.ifwd <TAB>
add-host-intent 00:00:00:00:00:01/-1 00:00:00:00:00:13/-1
feature:list -i
help onos:add-flows


#是否支持cluster
bundle:list | grep core-dist

#是否支持single
bundle:list | grep onos-core-trivial

#onos-group command can be used to automatically target all cell member VMs at once
onos-group install -f

#Utilities such as onos-service also take the --cell argument that enables it to manage all cell members at once
onos-service --cell restart

#本地build的bundle从本地的maven repo, push到remote的onos docker instances
byon-push-bits


cmd:
https://wiki.onosproject.org/display/ONOS/Appendix+C+%3A+Source+Tree+Organization
https://wiki.onosproject.org/display/ONOS/Appendix+A+%3A+CLI+commands

分布式onos配置
https://wiki.onosproject.org/display/ONOS/Distributed+ONOS
https://wiki.onosproject.org/display/ONOS/Distributed+ONOS+Tutorial
http://sdnhub.org/tutorials/onos/experimenting-with-onos-clustering/

test环境搭建
https://wiki.onosproject.org/display/ONOS/Test+Environment+Setup

dev环境搭建
https://wiki.onosproject.org/display/ONOS/Development+Environment+Setup

onos脚本介绍
https://wiki.onosproject.org/pages/viewpage.action?pageId=1048691
