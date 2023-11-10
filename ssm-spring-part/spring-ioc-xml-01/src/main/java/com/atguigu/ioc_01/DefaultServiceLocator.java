package com.atguigu.ioc_01;

public class DefaultServiceLocator {

  private static ClientServiceImpl clientService = new ClientServiceImpl();

  public ClientServiceImpl createClientServiceInstance() {
    return clientService;
  }
}