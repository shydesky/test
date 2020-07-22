import com.google.protobuf.ByteString;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.encoders.Hex;
import org.tron.common.crypto.ECKey;
import org.tron.protos.Contract.TriggerSmartContract;

public class Test {

  public static void main(String[] args) {
    ECKey ecKey = ECKey.fromPrivate("test".getBytes());
    byte[] msg = new byte[32];
    Arrays.fill(msg, (byte) 0x1);
    byte[] temp = ecKey.sign(msg).toByteArray();
    System.out.println(Hex.toHexString(temp));
    TriggerSmartContract.Builder builder = TriggerSmartContract.newBuilder();
    builder.setData(ByteString.copyFrom("data".getBytes()));
    TriggerSmartContract smartContract = builder.build();
    System.out.println(smartContract.getData());
  }
}