/**
 * BoundDataColumnList.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package org.eclipse.birt.report.soapengine.api;

public class BoundDataColumnList implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private org.eclipse.birt.report.soapengine.api.BoundDataColumn[] boundDataColumn;

	public BoundDataColumnList() {
	}

	public BoundDataColumnList(org.eclipse.birt.report.soapengine.api.BoundDataColumn[] boundDataColumn) {
		this.boundDataColumn = boundDataColumn;
	}

	/**
	 * Gets the boundDataColumn value for this BoundDataColumnList.
	 * 
	 * @return boundDataColumn
	 */
	public org.eclipse.birt.report.soapengine.api.BoundDataColumn[] getBoundDataColumn() {
		return boundDataColumn;
	}

	/**
	 * Sets the boundDataColumn value for this BoundDataColumnList.
	 * 
	 * @param boundDataColumn
	 */
	public void setBoundDataColumn(org.eclipse.birt.report.soapengine.api.BoundDataColumn[] boundDataColumn) {
		this.boundDataColumn = boundDataColumn;
	}

	public org.eclipse.birt.report.soapengine.api.BoundDataColumn getBoundDataColumn(int i) {
		return this.boundDataColumn[i];
	}

	public void setBoundDataColumn(int i, org.eclipse.birt.report.soapengine.api.BoundDataColumn _value) {
		this.boundDataColumn[i] = _value;
	}

	private java.lang.Object __equalsCalc = null;

	public synchronized boolean equals(java.lang.Object obj) {
		if (!(obj instanceof BoundDataColumnList))
			return false;
		BoundDataColumnList other = (BoundDataColumnList) obj;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (__equalsCalc != null) {
			return (__equalsCalc == obj);
		}
		__equalsCalc = obj;
		boolean _equals;
		_equals = true && ((this.boundDataColumn == null && other.getBoundDataColumn() == null)
				|| (this.boundDataColumn != null
						&& java.util.Arrays.equals(this.boundDataColumn, other.getBoundDataColumn())));
		__equalsCalc = null;
		return _equals;
	}

	private boolean __hashCodeCalc = false;

	public synchronized int hashCode() {
		if (__hashCodeCalc) {
			return 0;
		}
		__hashCodeCalc = true;
		int _hashCode = 1;
		if (getBoundDataColumn() != null) {
			for (int i = 0; i < java.lang.reflect.Array.getLength(getBoundDataColumn()); i++) {
				java.lang.Object obj = java.lang.reflect.Array.get(getBoundDataColumn(), i);
				if (obj != null && !obj.getClass().isArray()) {
					_hashCode += obj.hashCode();
				}
			}
		}
		__hashCodeCalc = false;
		return _hashCode;
	}

	// Type metadata
	private static org.apache.axis.description.TypeDesc typeDesc = new org.apache.axis.description.TypeDesc(
			BoundDataColumnList.class, true);

	static {
		typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.eclipse.org/birt", "BoundDataColumnList"));
		org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
		elemField.setFieldName("boundDataColumn");
		elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.eclipse.org/birt", "BoundDataColumn"));
		elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.eclipse.org/birt", "BoundDataColumn"));
		elemField.setMinOccurs(0);
		elemField.setNillable(false);
		elemField.setMaxOccursUnbounded(true);
		typeDesc.addFieldDesc(elemField);
	}

	/**
	 * Return type metadata object
	 */
	public static org.apache.axis.description.TypeDesc getTypeDesc() {
		return typeDesc;
	}

	/**
	 * Get Custom Serializer
	 */
	public static org.apache.axis.encoding.Serializer getSerializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanSerializer(_javaType, _xmlType, typeDesc);
	}

	/**
	 * Get Custom Deserializer
	 */
	public static org.apache.axis.encoding.Deserializer getDeserializer(java.lang.String mechType,
			java.lang.Class _javaType, javax.xml.namespace.QName _xmlType) {
		return new org.apache.axis.encoding.ser.BeanDeserializer(_javaType, _xmlType, typeDesc);
	}

}
