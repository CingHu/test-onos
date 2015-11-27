参考wiki:
https://wiki.onosproject.org/display/ONOS/Installing+and+Running+ONOS


Problem:
1. 找不到onos-package
   在$ONOS_ROOT/tools/build目录下

2. 运行onos-package出错
   apt-get install curl zip unzip cell

3. 安装时默认安装的APP
   export ONOS_APPS=drivers,openflow,proxyarp,mobility,fwd

4. 登录karaf
   http://42.62.101.229:8181/system/console/
   user:karaf, password:karaf

5. cd ~/.ml2
   user home directory. Running Maven at least once in the VM will generate the directory
