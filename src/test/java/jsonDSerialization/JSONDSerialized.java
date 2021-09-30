package jsonDSerialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataEntityUsers.UsersItem;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class JSONDSerialized {

    @Test
    public void dSerializationOfJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL("http://jsonplaceholder.typicode.com/users/");
        List<UsersItem> usersItemList = objectMapper.readValue(url, new TypeReference<List<UsersItem>>() {});
        usersItemList.forEach(System.out::println);

        }

    }



