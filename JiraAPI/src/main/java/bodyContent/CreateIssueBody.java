package bodyContent;

import java.util.HashMap;

public class CreateIssueBody {

    public static HashMap<String, Object> body() {

        HashMap<String, Object> body = new HashMap<>();

        HashMap<String, Object> fields = new HashMap<>();

        HashMap<String, String> project = new HashMap<>();
        project.put("key", "ATP");
        fields.put("project", project);

        HashMap<String, String> issuetype = new HashMap<>();
        issuetype.put("name", "Bug");
        fields.put("issuetype", issuetype);

        fields.put("summary", "This is a bug created by Rest Assure and body as HashMap");


        fields.put("description", new String[]{"value", "Description added by hashMap"});

        body.put("fields", fields);

        return body;

    }
}
