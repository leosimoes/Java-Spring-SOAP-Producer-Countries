# Spring - SOAP Producer - Countries
Autor: Leonardo Simões

A URI do Namespace deve ser a mesma para:
- os campos `xmlns:tns` e `targetNamespace` de `countries.xsd`;
- o atributo `NAMESPACE_URI` em `CountryEndpoint`;
- o parâmetro de `wsdl11Definition.setTargetNamespace` dentro do método `defaultWsdl11Definition` de `WebServiceConfig`;

![Image-08-UML-Classes-All](images/Image-08-UML-Classes-All.png)


## Etapas do desenvolvimento
As etapas de desenvolvimento do projeto foram:

1. Criar projeto (no IntelliJ) com:
- Linguagem Java (17);
- Spring Framework (6.2.3);
- Dependências: Web, Web Services, DevTools, Lombok;
- Plugins: Lombok e Jakarta EE: Web-Services (JAX-WS).

![Image-01-IntelliJ](images/Image-01-IntelliJ.png)

![Image-03-Plugin-Lombok](images/Image-03-Plugin-Lombok.png)

![Image-02-Plugin-Jax-ws](images/Image-02-Plugin-Jax-ws.png)

2. Em `src/main/resources`, criar arquivo `countries.xsd` para as definições para Country.

3. Em `pom.xml` adicionar as dependências e o plugin:

```xml
<project>
    <dependencies>
        <dependency>
            <groupId>wsdl4j</groupId>
            <artifactId>wsdl4j</artifactId>
            <version>1.6.3</version>
        </dependency>
        <dependency>
            <groupId>jakarta.xml.bind</groupId>
            <artifactId>jakarta.xml.bind-api</artifactId>
            <version>4.0.2</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jaxb</groupId>
            <artifactId>jaxb-runtime</artifactId>
            <version>4.0.5</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>jaxb2-maven-plugin</artifactId>
                <version>3.1.0</version>
                <executions>
                    <execution>
                        <id>xjc</id>
                        <goals>
                            <goal>xjc</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <sources>
                        <source>${project.basedir}/src/main/resources/countries.xsd</source>
                    </sources>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

4. Criar classes `Country`, `Currency`, `GetCountryRequest` e `GetCountryResponse` usando o plugin do Maven (ou chat GPT):

![Image-04-UML-Classes-Country-Currency-Request-Response](images/Image-04-UML-Classes-Country-Currency-Request-Response.png)

5. Criar classe `CountryInMemoryRepository`:
- com o atributo estático `countriesMap`;
- com o método `initData()` anotado com `@PostConstruct` para inicializar `countriesMap`;
- com o método `findCountry(String name)`.

![Image-05-UML-Class-CountryInMemoryRepository](images/Image-05-UML-Class-CountryInMemoryRepository.png)

6. Criar classe `CountryEndpoint`:
- com o atributo estático `NAMESPACE_URI`;
- com o atributo `CountryInMemoryRepository`inicializado no construtor que é anotado com `@Autowired`;
- com o método `getCountry`:
  * anotado com `@PayloadRoot` e `@ResponsePayload`;
  * com argumento `getCountryRequest` anotado com `RequestPayload`.

![Image-06-UML-Classes-CountryEndpoint](images/Image-06-UML-Classes-CountryEndpoint.png)

7. Criar classe `WebServiceConfig`:
- extends `WsConfigurerAdapter`;
- anotada com `@EnableWs` e `@Configuration`;
- com os 3 métodos anotados com `@Bean`.

![Image-07-UML-Class-WebServiceConfig](images/Image-07-UML-Class-WebServiceConfig.png)

8. Alterar URI do Namespace para `"http://spring.io/guides/gs-producing-web-service"` em:
- campos `xmlns:tns` e `targetNamespace` de `countries.xsd`;
- atributo `NAMESPACE_URI` em `CountryEndpoint`;
- parâmetro de `wsdl11Definition.setTargetNamespace` dentro do método `defaultWsdl11Definition` de `WebServiceConfig`;

9. Refatorar o código para cumprir o contrato SOAP
- excluir manualmente as classes `GetCountryRequest` e `GetCountryResponse`, que também foram geradas manualmente.
- separar a classe `Country` em `Country`(gerada automaticamente) e `CountryEntity`;
- criar a clase `CountryMapper` para converter de `CountryEntity` para `Country`;
- alterar a classe `CountryEndpoint` para usar as versões de `GetCountryRequest` e `GetCountryResponse` geradas automaticamente.


## Referências
Spring - Guides - Producing a SOAP web service:
https://spring.io/guides/gs/producing-web-service

Baeldung - Creating a SOAP Web Service with Spring:
https://www.baeldung.com/spring-boot-soap-web-service

Baeldung - Invoking a SOAP Web Service in Java:
https://www.baeldung.com/java-soap-web-service

Baeldung - Introduction to JAX-WS:
https://www.baeldung.com/jax-ws

MVN Repository - WSDL4J:
https://mvnrepository.com/artifact/wsdl4j/wsdl4j

MVN Repository - JAXB Core:
https://mvnrepository.com/artifact/org.glassfish.jaxb/jaxb-core

MVN Repository - JAXB Runtime:
https://mvnrepository.com/artifact/org.glassfish.jaxb/jaxb-runtime/

MVN Repository - Jakarta Activation API:
https://mvnrepository.com/artifact/jakarta.activation/jakarta.activation-api