package com.autogeneral.service;

import com.autogeneral.model.StatusResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

@Service
public class StatusServiceImpl implements StatusService {

	private static final Logger LOG = LoggerFactory.getLogger(StatusServiceImpl.class);

	@Override
	public StatusResponse getSystemStatus() {

		StatusResponse response = new StatusResponse();
		OperatingSystemMXBean mxBean = ManagementFactory.getOperatingSystemMXBean();
		Double loadAverage = mxBean.getSystemLoadAverage();

		LOG.debug("System Load Average - " + loadAverage.toString());
		if (loadAverage <= 60.00) {
			response.setStatus("healthy");
		}
		else {
			response.setStatus("unhealthy");
		}
		return response;
	}





}
