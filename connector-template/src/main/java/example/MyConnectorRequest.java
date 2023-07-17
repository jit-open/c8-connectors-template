package example;

import java.util.Objects;

public class MyConnectorRequest {

  private String status;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(status);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    MyConnectorRequest other = (MyConnectorRequest) obj;
    return Objects.equals(status, other.status);
  }

  @Override
  public String toString() {
    return "MyConnectorRequest [status=" + status + "]";
  }
}
