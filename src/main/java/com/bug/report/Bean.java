package com.bug.report;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.push.Push;
import jakarta.faces.push.PushContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class Bean implements Serializable{
	
	private String option;

	@Inject
	@Push PushContext wsPushNotifications;

	public void pushSenderListener(AjaxBehaviorEvent event) {
		Object o = switch(option) {
			case "RECORD"-> new SomeSampleRecord("RECORD iso", "RECORD continent", "RECORD country");
			case "AVRO"-> new SomeSample("AVRO iso", "AVRO continent", "AVRO country");
			case "POJO"-> new SomeSamplePojo("POJO iso", "POJO continent", "POJO country");
			default -> throw new IllegalArgumentException("Unsupported");
		};
		wsPushNotifications.send(List.of(o));
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public Collection<String> getAvailableOptions() {
		return List.of("RECORD", "AVRO", "POJO");
	}
}
