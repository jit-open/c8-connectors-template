package example;

import com.google.gson.Gson;
import com.sys1yagi.mastodon4j.MastodonClient;
import com.sys1yagi.mastodon4j.api.method.Statuses;
import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.error.ConnectorException;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@OutboundConnector(
    name = "MyConnectorFunction",
    inputVariables = {"status"},
    type = "example.MyConnectorFunction")
public class MyConnectorFunction implements OutboundConnectorFunction {

  private static final Logger LOGGER = LoggerFactory.getLogger(MyConnectorFunction.class);

  @Override
  public Object execute(OutboundConnectorContext context) throws Exception {
    var connectorRequest = context.getVariablesAsType(MyConnectorRequest.class);
    return executeConnector(connectorRequest);
  }

  private MyConnectorResult executeConnector(final MyConnectorRequest connectorRequest) {
    LOGGER.info("Executing my connector with request {}", connectorRequest);
    String status = connectorRequest.getStatus();
    if (status != null ) {
      throw new ConnectorException("FAILURE", "Status is null ");
    }

    String accessToken = "replace this string with the access token you have";
    String instanceName = "replace this instance name with the instance name you have";
    try {
      MastodonClient client = new MastodonClient.Builder(instanceName, new OkHttpClient.Builder(), new Gson())
              .accessToken(accessToken).build();

      Long inReplyToId = null;
      List<Long> mediaIds = null;
      boolean sensitive = false;
      String spoilerText = null;

      // Connect to the Mastodon API's statuses endpoint
      Statuses statusesEndpoint = new Statuses(client);

      // Post a status
      statusesEndpoint
              .postStatus(status, inReplyToId, mediaIds, sensitive, spoilerText)
              .execute();
    } catch (Exception e) {
      e.printStackTrace();
      throw new ConnectorException("Fail", "Mastodon posting status failed");
    }

    var result = new MyConnectorResult();
    result.setResult("Message received: " + status);
    return result;
  }
}
