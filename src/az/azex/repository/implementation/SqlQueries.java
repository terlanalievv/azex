package az.azex.repository.implementation;

public class SqlQueries {

    public static final String GET_PERSON_LIST ="select id, name, surname, status " +
            " from person " +
            " where status = 1";


    public static final String AUTHENTICATE_USER = "select id, email, password, name, surname, status " +
            "from azex_user " +
            "where email = ? and password = ? and status = 1";

    public static final String GET_USER_ROLES = "select r.id, r.name, " +
            " r.default_controller, r.default_page " +
            "from user_role ur inner join role r on ur.role_id = r.id " +
            " and ur.status = 1 and r.status = 1 " +
            "   inner join azex_user u on u.id = ur.user_id " +
            "where u.id = ?";

    public static final String GET_ALL_FLEXIBLE_LIST = "select id, name from flexible_list " +
            "where status = 1";

    public static final String GET_FLEXIBLE_LIST_BY_ID = "select id, name from flexible_list " +
            "where status = 1 and id = ?";

    public static final String GET_FLEXIBLE_LIST_ITEMS_BY_ID = "select fli.id, fli.value_id, fli.value_name, fli.insert_date " +
            "from flexible_list_item fli join flexible_list fl on fli.list_id = fl.id and fli.status = 1 and fl.status = 1 " +
            "where fl.id = ? " +
            "order by id";


}
