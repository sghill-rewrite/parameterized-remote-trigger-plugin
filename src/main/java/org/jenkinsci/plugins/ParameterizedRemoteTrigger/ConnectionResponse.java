package org.jenkinsci.plugins.ParameterizedRemoteTrigger;

import edu.umd.cs.findbugs.annotations.NonNull;

import net.sf.json.JSONObject;

import edu.umd.cs.findbugs.annotations.CheckForNull;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Http response containing header, body (JSON format) and response code.
 *
 */
public class ConnectionResponse
{
    @NonNull
    private final Map<String,List<String>> header = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Nullable @CheckForNull
    private final JSONObject body;

    @Nullable @CheckForNull
    private final String rawBody;

    @NonNull
    private final int responseCode;


    public ConnectionResponse(@NonNull Map<String, List<String>> header, @Nullable JSONObject body, @NonNull int responseCode)
    {
        loadHeader(header);
        this.body = body;
        this.rawBody = null;
        this.responseCode = responseCode;
    }

    public ConnectionResponse(@NonNull Map<String, List<String>> header, @Nullable String rawBody, @NonNull int responseCode)
    {
        loadHeader(header);
        this.body = null;
        this.rawBody = rawBody;
        this.responseCode = responseCode;
    }

    public ConnectionResponse(@NonNull Map<String, List<String>> header, @NonNull int responseCode)
    {
        loadHeader(header);
        this.body = null;
        this.rawBody = null;
        this.responseCode = responseCode;
    }

    private void loadHeader(Map<String, List<String>> header) {
        // null key is not compatible with the string Comparator, so we leave it out.
        Map<String, List<String>> filtered = header.entrySet().stream().filter(entry -> entry.getKey() != null).collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        this.header.putAll(filtered);
    }

    public Map<String,List<String>> getHeader()
    {
        return header;
    }

    public JSONObject getBody() {
        return body;
    }

    public String getRawBody() {
        return rawBody;
    }

    public int getResponseCode() {
        return responseCode;
    }

}
