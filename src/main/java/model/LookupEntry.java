package model;

import java.util.Objects;

public class LookupEntry {
    private int dstPort;
    private String protocol;
    private String tag;

    public LookupEntry(int dstPort, String protocol, String tag) {
        this.dstPort = dstPort;
        this.protocol = protocol.toLowerCase();
        this.tag = tag;
    }

    public String getPortProtocolKey() {
        return dstPort + "-" + protocol;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LookupEntry that = (LookupEntry) o;
        return dstPort == that.dstPort &&
                Objects.equals(protocol, that.protocol) &&
                Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dstPort, protocol, tag);
    }

	@Override
	public String toString() {
		return "LookupEntry [dstPort=" + dstPort + ", protocol=" + protocol + ", tag=" + tag + "]";
	}

	public int getDstPort() {
		return dstPort;
	}
	
	public String getProtocol() {
		return protocol;
	}

}
