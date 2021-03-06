package com.cn.vanke.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.vanke.dao.archibus.SiteCompanyMapper;
import com.cn.vanke.entity.SiteCompany;
import com.cn.vanke.page.domain.Pager;
import com.cn.vanke.persistence.sql.SqlMapper;
import com.cn.vanke.service.SiteCompanyService;

@Service
public class SiteCompanyServiceImpl implements SiteCompanyService {

	@Autowired
	private SiteCompanyMapper siteCompanyMapper;
	
	@Autowired
	private SqlMapper archibusSqlMapper;
	
	@Override
	public List<SiteCompany> query(Map<String, Object> params) {
		return siteCompanyMapper.query(params);
	}

	@Override
	public int insertIntoObject(SiteCompany siteCompany) {
		return archibusSqlMapper.insert("insert into afm.site_vn(site_id,vn_id,company) values('111111111','11111111','11111111')");
	}

	@Override
	public List<Map<String, Object>> queryDataByPage(Pager<Map<String, Object>> pager) {
		return this.siteCompanyMapper.queryDataByPage(pager);
	}

	@Override
	public List<SiteCompany> queryBeanDataByPage(Pager<SiteCompany> pager) {
		return this.siteCompanyMapper.queryBeanDataByPage(pager);
	}

	@Override
	public Pager<SiteCompany> queryPagerBeanBySqlMaper(Pager<SiteCompany> pager,String sql) {
		return this.archibusSqlMapper.selectListByPager(sql, SiteCompany.class, pager);
	}
}
