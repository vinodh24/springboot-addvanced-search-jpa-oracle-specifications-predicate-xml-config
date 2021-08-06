package com.vinodh.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the ALARM database table.
 * 
 */
@Entity
@Table(name = "alarm")
public class Alarm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen_alarm")
	@SequenceGenerator(name = "seq_gen_alarm", sequenceName = "SEQ_ALARM",allocationSize = 1, initialValue = 1)
	@Column(name = "id")
	private long id;
	
	@Column(name = "severity")
	private String severity;

	@Column(name = "nodename")
    private String nodeName;
	
	@Column(name = "clli")
    private String clli;

	@Column(name = "emsname")
    private String emsName;

	@Column(name = "category")
    private String category;

	@Column(name = "occurrenceTime")
    private String occurrenceTime;
	
	@Column(name = "occurrence")
    private long occurrence;

	@Column(name = "emsIp")
    private String emsIp;

	@Column(name = "nodeIp")
    private String nodeIp;

	@Column(name = "emsId")
    private long emsId;

	@Column(name = "nodeId")
    private long nodeId;
	
	@Column(name = "protocol")
    private String protocol;
	
	@Column(name = "port")
    private int port;

	@Column(name = "deviceType")
    private String deviceType;

	@Column(name = "identifier")
    private String identifier;

	@Column(name = "type")
    private String type;

	@Column(name = "tid")
    private String tid;

	@Column(name = "sid")
    private String sid;

	@Column(name = "receivedTime")
    private Timestamp receivedTime;
	
	@Column(name = "alarmcode")
    private String alarmCode;

	@Column(name = "atag")
    private String atag;

	@Column(name = "verb")
    private String verb;

	@Column(name = "modifier1")
    private String modifier1;

	@Column(name = "modifier2")
    private String modifier2;

	@Column(name = "comment01")
    private String comment01;

	@Column(name = "comment02")
    private String comment02;

	@Column(name = "quotedline")
    private String quotedline;

	@Column(name = "section1field1")
    private String section1Field1;

	@Column(name = "section2field1")
    private String section2Field1;

    @Column(name = "section2field2")
    private String section2Field2;

	@Column(name = "section2field3")
    private String section2Field3;

	@Column(name = "section2field4")
    private String section2Field4;

	@Column(name = "section2field5")
    private String section2Field5;

	@Column(name = "section2field6")
    private String section2Field6;

	@Column(name = "section2field7")
    private String section2Field7;

	@Column(name = "section2field8")
    private String section2Field8;

	@Column(name = "section2field9")
    private String section2Field9;

	@Column(name = "section2field10")
    private String section2Field10;

	@Column(name = "section3field1")
    private String section3Field1;

	@Column(name = "section3field2")
    private String section3Field2;

	@Column(name = "section3field3")
    private String section3Field3;

	@Column(name = "section3field4")
    private String section3Field4;

	@Column(name = "section4field1")
    private String section4Field1;

	@Column(name = "section4field2")
    private String section4Field2;

	@Column(name = "traprequestid")
	private int trapRequestId;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "workgroups")
	private String workGroups;
	
	@Column(name = "centraloffice")
	private String centralOffice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getEmsName() {
		return emsName;
	}

	public void setEmsName(String emsName) {
		this.emsName = emsName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOccurrenceTime() {
		return occurrenceTime;
	}

	public void setOccurrenceTime(String occurrenceTime) {
		this.occurrenceTime = occurrenceTime;
	}

	public long getOccurrence() {
		return occurrence;
	}

	public void setOccurrence(long occurrence) {
		this.occurrence = occurrence;
	}

	public String getEmsIp() {
		return emsIp;
	}

	public void setEmsIp(String emsIp) {
		this.emsIp = emsIp;
	}

	public String getNodeIp() {
		return nodeIp;
	}

	public void setNodeIp(String nodeIp) {
		this.nodeIp = nodeIp;
	}

	public long getEmsId() {
		return emsId;
	}

	public void setEmsId(long emsId) {
		this.emsId = emsId;
	}

	public long getNodeId() {
		return nodeId;
	}

	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Timestamp getReceivedTime() {
		return receivedTime;
	}

	public void setReceivedTime(Timestamp receivedTime) {
		this.receivedTime = receivedTime;
	}

	public String getAlarmCode() {
		return alarmCode;
	}

	public void setAlarmCode(String alarmCode) {
		this.alarmCode = alarmCode;
	}

	public String getAtag() {
		return atag;
	}

	public void setAtag(String atag) {
		this.atag = atag;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(String verb) {
		this.verb = verb;
	}

	public String getModifier1() {
		return modifier1;
	}

	public void setModifier1(String modifier1) {
		this.modifier1 = modifier1;
	}

	public String getModifier2() {
		return modifier2;
	}

	public void setModifier2(String modifier2) {
		this.modifier2 = modifier2;
	}

	public String getComment01() {
		return comment01;
	}

	public void setComment01(String comment01) {
		this.comment01 = comment01;
	}

	public String getComment02() {
		return comment02;
	}

	public void setComment02(String comment02) {
		this.comment02 = comment02;
	}

	public String getQuotedline() {
		return quotedline;
	}

	public void setQuotedline(String quotedline) {
		this.quotedline = quotedline;
	}

	public String getSection1Field1() {
		return section1Field1;
	}

	public void setSection1Field1(String section1Field1) {
		this.section1Field1 = section1Field1;
	}

	public String getSection2Field1() {
		return section2Field1;
	}

	public void setSection2Field1(String section2Field1) {
		this.section2Field1 = section2Field1;
	}

	public String getSection2Field2() {
		return section2Field2;
	}

	public void setSection2Field2(String section2Field2) {
		this.section2Field2 = section2Field2;
	}

	public String getSection2Field3() {
		return section2Field3;
	}

	public void setSection2Field3(String section2Field3) {
		this.section2Field3 = section2Field3;
	}

	public String getSection2Field4() {
		return section2Field4;
	}

	public void setSection2Field4(String section2Field4) {
		this.section2Field4 = section2Field4;
	}

	public String getSection2Field5() {
		return section2Field5;
	}

	public void setSection2Field5(String section2Field5) {
		this.section2Field5 = section2Field5;
	}

	public String getSection2Field6() {
		return section2Field6;
	}

	public void setSection2Field6(String section2Field6) {
		this.section2Field6 = section2Field6;
	}

	public String getSection2Field7() {
		return section2Field7;
	}

	public void setSection2Field7(String section2Field7) {
		this.section2Field7 = section2Field7;
	}

	public String getSection2Field8() {
		return section2Field8;
	}

	public void setSection2Field8(String section2Field8) {
		this.section2Field8 = section2Field8;
	}

	public String getSection2Field9() {
		return section2Field9;
	}

	public void setSection2Field9(String section2Field9) {
		this.section2Field9 = section2Field9;
	}

	public String getSection2Field10() {
		return section2Field10;
	}

	public void setSection2Field10(String section2Field10) {
		this.section2Field10 = section2Field10;
	}

	public String getSection3Field1() {
		return section3Field1;
	}

	public void setSection3Field1(String section3Field1) {
		this.section3Field1 = section3Field1;
	}

	public String getSection3Field2() {
		return section3Field2;
	}

	public void setSection3Field2(String section3Field2) {
		this.section3Field2 = section3Field2;
	}

	public String getSection3Field3() {
		return section3Field3;
	}

	public void setSection3Field3(String section3Field3) {
		this.section3Field3 = section3Field3;
	}

	public String getSection3Field4() {
		return section3Field4;
	}

	public void setSection3Field4(String section3Field4) {
		this.section3Field4 = section3Field4;
	}

	public String getSection4Field1() {
		return section4Field1;
	}

	public void setSection4Field1(String section4Field1) {
		this.section4Field1 = section4Field1;
	}

	public String getSection4Field2() {
		return section4Field2;
	}

	public void setSection4Field2(String section4Field2) {
		this.section4Field2 = section4Field2;
	}

	public int getTrapRequestId() {
		return trapRequestId;
	}

	public void setTrapRequestId(int trapRequestId) {
		this.trapRequestId = trapRequestId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWorkGroups() {
		return workGroups;
	}

	public void setWorkGroups(String workGroups) {
		this.workGroups = workGroups;
	}

	public String getCentralOffice() {
		return centralOffice;
	}

	public void setCentralOffice(String centralOffice) {
		this.centralOffice = centralOffice;
	}

	public String getClli() {
		return clli;
	}

	public void setClli(String clli) {
		this.clli = clli;
	}

	@Override
	public String toString() {
		return "Alarm [id=" + id + ", severity=" + severity + ", nodeName=" + nodeName + ", clli=" + clli + ", emsName="
				+ emsName + ", category=" + category + ", occurrenceTime=" + occurrenceTime + ", occurrence="
				+ occurrence + ", emsIp=" + emsIp + ", nodeIp=" + nodeIp + ", emsId=" + emsId + ", nodeId=" + nodeId
				+ ", protocol=" + protocol + ", port=" + port + ", deviceType=" + deviceType + ", identifier="
				+ identifier + ", type=" + type + ", tid=" + tid + ", sid=" + sid + ", receivedTime=" + receivedTime
				+ ", alarmCode=" + alarmCode + ", atag=" + atag + ", verb=" + verb + ", modifier1=" + modifier1
				+ ", modifier2=" + modifier2 + ", comment01=" + comment01 + ", comment02=" + comment02 + ", quotedline="
				+ quotedline + ", section1Field1=" + section1Field1 + ", section2Field1=" + section2Field1
				+ ", section2Field2=" + section2Field2 + ", section2Field3=" + section2Field3 + ", section2Field4="
				+ section2Field4 + ", section2Field5=" + section2Field5 + ", section2Field6=" + section2Field6
				+ ", section2Field7=" + section2Field7 + ", section2Field8=" + section2Field8 + ", section2Field9="
				+ section2Field9 + ", section2Field10=" + section2Field10 + ", section3Field1=" + section3Field1
				+ ", section3Field2=" + section3Field2 + ", section3Field3=" + section3Field3 + ", section3Field4="
				+ section3Field4 + ", section4Field1=" + section4Field1 + ", section4Field2=" + section4Field2
				+ ", trapRequestId=" + trapRequestId + ", location=" + location + ", workGroups=" + workGroups
				+ ", centralOffice=" + centralOffice + "]";
	}
	
}