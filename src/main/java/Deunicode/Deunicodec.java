package Deunicode;

import org.apache.commons.text.StringEscapeUtils;

public class Deunicodec {
    public static void main(String[] args) {
        StringBuilder a = new StringBuilder();
        a.append("\"<html>\\r\\n<head>\\r\\n<meta http-equiv=\\\"Content-Type\\\" content=\\\"text/html; charset=UTF-8\\\">\\r\\n</head>\\r\\n\\t<body style=\\\"overflow:hidden\\\">\\r\\n\\t\\t<div style=\\\"width: 450px;\\r\\n    height: 300px;\\r\\n    background: url(/images/error/500.png) no-repeat 50%;\\r\\n    top: 50%;\\r\\n    left: 50%;\\r\\n    margin: auto auto;\\r\\n    text-align: center;\\r\\n    margin-top: 100px;\\\">\\r\\n\\t\\t\\t<div style=\\\"height: 30px;\\r\\n    color: #b2b2b2;\\r\\n    font-size: 22px;\\r\\n    padding-top: 170px;\\r\\n    padding-left: 200px;\\\">\\u60a8\\u6240\\u8bf7\\u6c42\\u7684\\u7f51\\u9875\\u51fa\\u73b0\\u5f02\\u5e38</div>\\r\\n\\t\\t</div>\\r\\n\\t</body>\\r\\n</html>\\r\\n\\r\\n\"");
        String b = StringEscapeUtils.unescapeJava(a.toString());
        System.out.println(b);
    }
}
