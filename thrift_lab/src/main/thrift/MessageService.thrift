namespace java src.main.gen

/**
 * 消息类型
 **/
enum MSG_TYPE{
    /**
     * 错误
     **/
    ERROR = 1,
    
    /**
     * 信息
     **/
    INFO = 2,
    
    /**
     * 调试信息
     **/
    DEBUG =3
}

/**
 * 返回值
 **/
enum RESULT_CODE{
    OK,
    FAIL
}

/**
 * 消息主体
 **/
struct Message {

    //消息类型
    1: required MSG_TYPE type;

    //消息内容
    2: required string message;

    //创建时间
    3: required i64 createTime;

    //是否存储到DB
    4: optional bool isStore;
}

service MessageService{
    RESULT_CODE log(1:list<Message> messages)
}
