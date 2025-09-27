package api.endpoints;
//Swagger URI --> https://petstore.swagger.io

//(Post) - https://petstore.swagger.io/v2/user
//(Get) - https://petstore.swagger.io/v2/user/{username}
//(Put) - https://petstore.swagger.io/v2/user/{username}
//(Delete) - https://petstore.swagger.io/v2/user/{username}

public class routes {
    public static String base_url = "https://petstore.swagger.io/v2";
    //User module
    public static String post_url = base_url + "/user";
    public static String get_url = base_url + "/user/{username}";
    public static String put_url = base_url + "/user/{username}";
    public static String delete_url = base_url + "/user/{username}";

    //Pet Module
    public static String post_url_1 = base_url + "/pet";
    public static String get_url_1 = base_url + "/pet/{petId}";
    public static String put_url_1 = base_url + "/pet/{petId}";
    public static String delete_url_1 = base_url + "/pet/{petId}";

    //Store Module
    public static String post_url_2 = base_url + "/store/order";
    public static String get_url_2 = base_url + "/store/inventory";
    public static String put_url_2 = base_url + "/store/order/{orderId}";
    public static String delete_url_2 = base_url + "/store/order/{orderId}";


}
