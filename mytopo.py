import abc
import six


from mininet.topo import Topo



@six.add_metaclass(abc.ABCMeta)
class MyTopo(Topo):
    ''' simple topo '''
    def __init__(self):
        Topo.__init__(self)
        
        host1 = self.addHost('h1')
        host2 = self.addHost('h2')
  
        switch1 = self.addSwitch('s1') 
        switch2 = self.addSwitch('s2') 

        self.addLink(host1, switch1)
        self.addLink(host2, switch2)
        self.addLink(switch1, switch2)

topos = {'mytopo': (lambda: MyTopo())}

