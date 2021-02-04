package io.pivotal.services.dataTx.geode.client;

/**
 * Connection builder abstraction
 * @author Gregory Green
 */
public interface ConnectionBuilder
{
    public void addHostPort(String host, int port);
}
