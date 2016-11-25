/**
 *@filename FamilyDTO.java
 *@Email tengzhenjiu@qq.com
 *
 */
package com.lapism.searchview.dto;

import android.R.integer;

/**
 * @Title FamilyDTO
 * @author tengzj
 * @data 2016��8��24�� ����9:59:35
 */

/*
 * ��ͥ��Ϣ ��� �ֶ����� ���� ���� ���� �ǿ� ��ע AAB999 ��ͥ��� Varchar2 16 Ϊ�մ����µǼǼ�ͥ AAB400 ��������
 * Varchar2 50 �� AAC058 ����֤������ Varchar2 3 �� ������� AAE135 ����֤������ Varchar2 20 ��
 * AAB401 ������� Varchar2 20 BAB041 �α����� number 3 AAE005 ��ϵ�绰 Varchar2 50 AAE006
 * סַ Varchar2 100 AAB050 �Ǽ����� Varchar2 10 �� ��ʽ��yyyymmdd
 */

public class Family {
	public String id;
	public String lsh;
	public String edit_jtbh;
	public String edit_jhzzjlx;
	public String edit_gmcfzh;
	public String edit_jgszcwh;
	public String edit_hzxm;
	public String edit_hjbh;
	public String edit_lxdh;
	public String edit_dzyx;
	public String edit_yzbm;
	public String edit_cjqtbxrs;
	public String edit_hkxxdz;
	public String edit_djrq;
	public String xzqh;
	public String isEdit = "0"; // 0δ�޸� 1�޸���
	public String isUpload = "0";// 0wδ�ϴ� 1���ϴ�

	/**
	 * @param string
	 * @param string2
	 * @param string3
	 * @param string4
	 *            /* ��ͥ��Ϣ ��� �ֶ����� ���� ���� ���� �ǿ� ��ע AAB999 ��ͥ��� Varchar2 16
	 *            Ϊ�մ����µǼǼ�ͥ getEdit_hzxm AAB400 �������� Varchar2 50 �� AAC058 ����֤������
	 *            Varchar2 3 �� ������� getEdit_gmcfzh AAE135 ����֤������ Varchar2 20 ��
	 *            AAB401 ������� Varchar2 20 getEdit_cjqtbxrs BAB041 �α����� number 3
	 *            getEdit_lxdh AAE005 ��ϵ�绰 Varchar2 50 getEdit_hkxxdz AAE006 סַ
	 *            Varchar2 100 getEdit_djrq AAB050 �Ǽ����� Varchar2 10 ��
	 *            ��ʽ��yyyymmdd
	 */
	public Family(String edit_gmcfzh, String edit_jgszcwh, String edit_hzxm, String edit_hjbh, String edit_lxdh) {
		// TODO Auto-generated constructor stub
		this.edit_gmcfzh = edit_gmcfzh;
		this.edit_jgszcwh = edit_jgszcwh;
		this.edit_hzxm = edit_hzxm;
		this.edit_hjbh = edit_hjbh;
		this.edit_lxdh = edit_lxdh;
	}

	/**
	 * 
	 */
	public Family() {
		// TODO Auto-generated constructor stub
		this.edit_jhzzjlx = "";
		this.edit_gmcfzh = "";
		this.edit_jgszcwh = "";
		this.edit_hzxm = "";
		this.edit_hjbh = "";
		this.edit_lxdh = "";
		this.edit_dzyx = "";
		this.edit_yzbm = "";
		this.edit_cjqtbxrs = "0";
		this.edit_hkxxdz = "";
		this.edit_djrq = "";
		this.isEdit = "0";
		this.isUpload = "0";
	}

	/**
	 * @return the edit_gmcfzh
	 */
	public String getEdit_gmcfzh() {
		return edit_gmcfzh;
	}

	/**
	 * @param edit_gmcfzh
	 *            the edit_gmcfzh to set
	 */
	public void setEdit_gmcfzh(String edit_gmcfzh) {
		this.edit_gmcfzh = edit_gmcfzh;
	}

	/**
	 * @return the edit_jgszcwh
	 */
	public String getEdit_jgszcwh() {
		return edit_jgszcwh;
	}

	/**
	 * @param edit_jgszcwh
	 *            the edit_jgszcwh to set
	 */
	public void setEdit_jgszcwh(String edit_jgszcwh) {
		this.edit_jgszcwh = edit_jgszcwh;
	}

	/**
	 * @return the edit_hzxm
	 */
	public String getEdit_hzxm() {
		return edit_hzxm;
	}

	/**
	 * @param edit_hzxm
	 *            the edit_hzxm to set
	 */
	public void setEdit_hzxm(String edit_hzxm) {
		this.edit_hzxm = edit_hzxm;
	}

	/**
	 * @return the edit_hjbh
	 */
	public String getEdit_hjbh() {
		return edit_hjbh;
	}

	/**
	 * @param edit_hjbh
	 *            the edit_hjbh to set
	 */
	public void setEdit_hjbh(String edit_hjbh) {
		this.edit_hjbh = edit_hjbh;
	}

	/**
	 * @return the edit_lxdh
	 */
	public String getEdit_lxdh() {
		return edit_lxdh;
	}

	/**
	 * @param edit_lxdh
	 *            the edit_lxdh to set
	 */
	public void setEdit_lxdh(String edit_lxdh) {
		this.edit_lxdh = edit_lxdh;
	}

	/**
	 * @return the edit_dzyx
	 */
	public String getEdit_dzyx() {
		return edit_dzyx;
	}

	/**
	 * @param edit_dzyx
	 *            the edit_dzyx to set
	 */
	public void setEdit_dzyx(String edit_dzyx) {
		this.edit_dzyx = edit_dzyx;
	}

	/**
	 * @return the edit_yzbm
	 */
	public String getEdit_yzbm() {
		return edit_yzbm;
	}

	/**
	 * @param edit_yzbm
	 *            the edit_yzbm to set
	 */
	public void setEdit_yzbm(String edit_yzbm) {
		this.edit_yzbm = edit_yzbm;
	}

	/**
	 * @return the edit_cjqtbxrs
	 */
	public String getEdit_cjqtbxrs() {
		return edit_cjqtbxrs;
	}

	/**
	 * @param edit_cjqtbxrs
	 *            the edit_cjqtbxrs to set
	 */
	public void setEdit_cjqtbxrs(String edit_cjqtbxrs) {
		this.edit_cjqtbxrs = edit_cjqtbxrs;
	}

	/**
	 * @return the edit_hkxxdz
	 */
	public String getEdit_hkxxdz() {
		return edit_hkxxdz;
	}

	/**
	 * @param edit_hkxxdz
	 *            the edit_hkxxdz to set
	 */
	public void setEdit_hkxxdz(String edit_hkxxdz) {
		this.edit_hkxxdz = edit_hkxxdz;
	}

	@Override
	public String toString() {
		return "Family [id=" + id + ", edit_jtbh=" + edit_jtbh + ", edit_jhzzjlx=" + edit_jhzzjlx + ", edit_gmcfzh="
				+ edit_gmcfzh + ", edit_jgszcwh=" + edit_jgszcwh + ", edit_hzxm=" + edit_hzxm + ", edit_hjbh="
				+ edit_hjbh + ", edit_lxdh=" + edit_lxdh + ", edit_dzyx=" + edit_dzyx + ", edit_yzbm=" + edit_yzbm
				+ ", edit_cjqtbxrs=" + edit_cjqtbxrs + ", edit_hkxxdz=" + edit_hkxxdz + ", edit_djrq=" + edit_djrq
				+ ", isEdit=" + isEdit + ", isUpload=" + isUpload + "]";
	}

	public String getEdit_djrq() {
		return edit_djrq;
	}

	public void setEdit_djrq(String edit_djrq) {
		this.edit_djrq = edit_djrq;
	}

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	public String getIsUpload() {
		return isUpload;
	}

	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEdit_jhzzjlx() {
		return edit_jhzzjlx;
	}

	public void setEdit_jhzzjlx(String edit_jhzzjlx) {
		this.edit_jhzzjlx = edit_jhzzjlx;
	}

	public String getEdit_jtbh() {
		return edit_jtbh;
	}

	public void setEdit_jtbh(String edit_jtbh) {
		this.edit_jtbh = edit_jtbh;
	}

	public String getXzqh() {
		return xzqh;
	}

	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}

	public String getLsh() {
		return lsh;
	}

	public void setLsh(String lsh) {
		this.lsh = lsh;
	}

}
