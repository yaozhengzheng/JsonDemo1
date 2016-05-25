package com.yao.feicui.jsondemo1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * 完成对JSON 数据的解析
 * Created by 16245 on 2016/05/25.
 */
public class JsonTools {
    public JsonTools() {
    }

    /**
     * 获取对象数据
     *
     * @param jsonString
     * @return
     */
    public static List<Person> getPerson(String jsonString) {
        List<Person> personList = new ArrayList<>();

        try {

            if (jsonString != null) {
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONArray jsonArray = (JSONArray) jsonObject.get("students");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                    Person person1 = new Person();
                    person1.setName(jsonObject1.getString("name"));
                    person1.setAge(jsonObject1.getInt("age"));
                    personList.add(person1);

                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return personList;
    }

}
