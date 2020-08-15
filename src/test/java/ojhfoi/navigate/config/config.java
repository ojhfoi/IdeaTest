package ojhfoi.navigate.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config.properties"})
public interface config extends Config {

    @Key("server.url")
    String hostname();

    @Key("user.login")
    String login();

    @Key("user.password")
    String pass();


}
