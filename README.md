# SOAP Web Service з JAXB та XSD

Цей проєкт демонструє:

- створення SOAP WebService на Spring Boot
- генерацію класів з XSD за допомогою `jaxb-maven-plugin`
- ручне тестування SOAP endpoint через `curl` або Postman

---

## 📦 Збірка проєкту

### Встановлення залежностей
Переконайтесь, що у вас встановлено:
- JDK 17+
- Maven 3.6+

---

## ▶ Запуск сервісу

```bash
mvn spring-boot:run
```

> Додаток підніметься на `http://localhost:8080`

---

## 📄 Доступ до WSDL

SOAP WebService WSDL доступний за адресою:

```
http://localhost:8080/ws/users.wsdl
```

---

## 🧪 Тестування ендпоінту

### Приклад SOAP-запиту (request.xml):

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:usr="http://localhost/users">
   <soapenv:Header/>
   <soapenv:Body>
      <usr:getUserRequest>
         <usr:id>1</usr:id>
      </usr:getUserRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

### Відправка через `curl`:

```bash
curl -X POST http://localhost:8080/ws \
  -H "Content-Type: text/xml" \
  --data-binary @request.xml
```

---

## 📤 Очікувана відповідь

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/">
   <soapenv:Body>
      <ns2:getUserResponse xmlns:ns2="http://localhost/users">
         <ns2:user>
            <ns2:id>1</ns2:id>
            <ns2:name>Ім'я користувача</ns2:name>
         </ns2:user>
      </ns2:getUserResponse>
   </soapenv:Body>
</soapenv:Envelope>
```

---

