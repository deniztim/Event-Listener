package com.example.tutorial.plugins;

import com.atlassian.event.api.EventListener;
import com.atlassian.event.api.EventPublisher;
import com.atlassian.jira.event.issue.IssueEvent;
import com.atlassian.jira.event.type.EventType;
import com.atlassian.jira.issue.Issue;
import com.atlassian.plugin.spring.scanner.annotation.imports.JiraImport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class IssueCreatedResolvedListener {
     private static final Logger log = LoggerFactory.getLogger(IssueCreatedResolvedListener.class);
 }
 
 @Autowired
public IssueCreatedResolvedListener(@JiraImport EventPublisher eventPublisher) {
    eventPublisher.register(this);    // Demonstration only -- don't do this in real code!
}

@EventListener
public void onIssueEvent(IssueEvent issueEvent) {
   Long eventTypeId = issueEvent.getEventTypeId();
   Issue issue = issueEvent.getIssue();

   if (eventTypeId.equals(EventType.ISSUE_CREATED_ID)) {
      log.info("Issue {} has been created at {}.", issue.getKey(), issue.getCreated());
   } else if (eventTypeId.equals(EventType.ISSUE_RESOLVED_ID)) {
      log.info("Issue {} has been resolved at {}.", issue.getKey(), issue.getResolutionDate());
   } else if (eventTypeId.equals(EventType.ISSUE_CLOSED_ID)) {
      log.info("Issue {} has been closed at {}.", issue.getKey(), issue.getUpdated());
   }
}