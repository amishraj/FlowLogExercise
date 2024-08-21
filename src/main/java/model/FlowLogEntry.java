package model;

import java.util.Objects;

public class FlowLogEntry {
	private int version;
    private String accountId;
    private String eniId;
    private String srcIp;
    private String dstIp;
    private int dstPort;
    private int srcPort;
    private int protocol;
    private long packets;
    private long bytes;
    private long startTime;
    private long endTime;
    private String action;
    private String status;

    public FlowLogEntry(int version, String accountId, String eniId, String srcIp, String dstIp, int dstPort, int srcPort, int protocol,
                        long packets, long bytes, long startTime, long endTime, String action, String status) {
        this.version = version;
        this.accountId=accountId;
        this.eniId = eniId;
        this.srcIp = srcIp;
        this.dstIp = dstIp;
        this.dstPort = dstPort;
        this.srcPort = srcPort;
        this.protocol = protocol;
        this.packets = packets;
        this.bytes = bytes;
        this.startTime = startTime;
        this.endTime = endTime;
        this.action = action;
        this.status = status;
    }

    public String getPortProtocolKey() {
        return dstPort + "-" + getProtocolName();
    }

    String getProtocolName() {
        switch (protocol) {
            case 6: return "tcp";
            case 17: return "udp";
            case 1: return "icmp";
            default: return "unknown";
        }
    }
    
    public String getSrcIp() {
		return srcIp;
	}

	public String getDstIp() {
		return dstIp;
	}

	public int getDstPort() {
		return dstPort;
	}

	public int getProtocol() {
		return protocol;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountId, action, bytes, dstIp, dstPort, endTime, eniId, packets, protocol, srcIp, srcPort,
				startTime, status, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlowLogEntry other = (FlowLogEntry) obj;
		return Objects.equals(accountId, other.accountId) && Objects.equals(action, other.action)
				&& bytes == other.bytes && Objects.equals(dstIp, other.dstIp) && dstPort == other.dstPort
				&& endTime == other.endTime && Objects.equals(eniId, other.eniId) && packets == other.packets
				&& protocol == other.protocol && Objects.equals(srcIp, other.srcIp) && srcPort == other.srcPort
				&& startTime == other.startTime && Objects.equals(status, other.status) && version == other.version;
	}

	@Override
	public String toString() {
		return "FlowLogEntry [version=" + version + ", accountId=" + accountId + ", eniId=" + eniId + ", srcIp=" + srcIp
				+ ", dstIp=" + dstIp + ", dstPort=" + dstPort + ", srcPort=" + srcPort + ", protocol=" + protocol
				+ ", packets=" + packets + ", bytes=" + bytes + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", action=" + action + ", status=" + status + "]";
	}
}