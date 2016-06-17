package de.yveskaufmann.restspawn.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class Repository {

	private long id;
	private User owner;
	private String name;
	private String full_name;
	private String description;
	private boolean fork;
	@JsonProperty("private")
	private boolean Private;

	private List<String> languages;
	private long forkCount;
	private long stargazers_count;
	private long watchers_count;
	private long size;
	private String defaultBranch;
	private long open_issue_count;
	private boolean has_issues;
	private boolean has_wiki;
	private boolean has_pages;
	private boolean has_downloads;
	private LocalDateTime pushed_at;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private Permissions permissions;

	private String url;
	private String html_url;
	private String archive_url;
	private String assignees_url;
	private String blobs_url;
	private String branches_url;
	private String clone_url;
	private String collaborators_url;
	private String comments_url;
	private String commits_url;
	private String compare_url;
	private String contents_url;
	private String contributors_url;
	private String deployments_url;
	private String downloads_url;
	private String events_url;
	private String forks_url;
	private String git_commits_url;
	private String git_refs_url;
	private String git_tags_url;
	private String git_url;
	private String hooks_url;
	private String issue_comment_url;
	private String issue_events_url;
	private String issues_url;
	private String keys_url;
	private String labels_url;
	private String languages_url;
	private String merges_url;
	private String milestones_url;
	private String mirror_url;
	private String notifications_url;
	private String pulls_url;
	private String releases_url;
	private String ssh_url;
	private String stargazers_url;
	private String statuses_url;
	private String subscribers_url;
	private String subscription_url;
	private String svn_url;
	private String tags_url;
	private String teams_url;
	private String trees_url;
	private String homepage;

	public long getId() {
		return id;
	}

	public User getOwner() {return owner;}

	public String getName() {
		return name;
	}

	public String getFull_name() {
		return full_name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isFork() {
		return fork;
	}

	public boolean isPrivate() {
		return Private;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public long getForkCount() {
		return forkCount;
	}

	public long getStargazers_count() {
		return stargazers_count;
	}

	public long getWatchers_count() {
		return watchers_count;
	}

	public long getSize() {
		return size;
	}

	public String getDefaultBranch() {
		return defaultBranch;
	}

	public long getOpen_issue_count() {
		return open_issue_count;
	}

	public boolean isHas_issues() {
		return has_issues;
	}

	public boolean isHas_wiki() {
		return has_wiki;
	}

	public boolean isHas_pages() {
		return has_pages;
	}

	public boolean isHas_downloads() {
		return has_downloads;
	}

	public LocalDateTime getPushed_at() {
		return pushed_at;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public Permissions getPermissions() {
		return permissions;
	}

	public String getUrl() {
		return url;
	}

	public String getHtml_url() {
		return html_url;
	}

	public String getArchive_url() {
		return archive_url;
	}

	public String getAssignees_url() {
		return assignees_url;
	}

	public String getBlobs_url() {
		return blobs_url;
	}

	public String getBranches_url() {
		return branches_url;
	}

	public String getClone_url() {
		return clone_url;
	}

	public String getCollaborators_url() {
		return collaborators_url;
	}

	public String getComments_url() {
		return comments_url;
	}

	public String getCommits_url() {
		return commits_url;
	}

	public String getCompare_url() {
		return compare_url;
	}

	public String getContents_url() {
		return contents_url;
	}

	public String getContributors_url() {
		return contributors_url;
	}

	public String getDeployments_url() {
		return deployments_url;
	}

	public String getDownloads_url() {
		return downloads_url;
	}

	public String getEvents_url() {
		return events_url;
	}

	public String getForks_url() {
		return forks_url;
	}

	public String getGit_commits_url() {
		return git_commits_url;
	}

	public String getGit_refs_url() {
		return git_refs_url;
	}

	public String getGit_tags_url() {
		return git_tags_url;
	}

	public String getGit_url() {
		return git_url;
	}

	public String getHooks_url() {
		return hooks_url;
	}

	public String getIssue_comment_url() {
		return issue_comment_url;
	}

	public String getIssue_events_url() {
		return issue_events_url;
	}

	public String getIssues_url() {
		return issues_url;
	}

	public String getKeys_url() {
		return keys_url;
	}

	public String getLabels_url() {
		return labels_url;
	}

	public String getLanguages_url() {
		return languages_url;
	}

	public String getMerges_url() {
		return merges_url;
	}

	public String getMilestones_url() {
		return milestones_url;
	}

	public String getMirror_url() {
		return mirror_url;
	}

	public String getNotifications_url() {
		return notifications_url;
	}

	public String getPulls_url() {
		return pulls_url;
	}

	public String getReleases_url() {
		return releases_url;
	}

	public String getSsh_url() {
		return ssh_url;
	}

	public String getStargazers_url() {
		return stargazers_url;
	}

	public String getStatuses_url() {
		return statuses_url;
	}

	public String getSubscribers_url() {
		return subscribers_url;
	}

	public String getSubscription_url() {
		return subscription_url;
	}

	public String getSvn_url() {
		return svn_url;
	}

	public String getTags_url() {
		return tags_url;
	}

	public String getTeams_url() {
		return teams_url;
	}

	public String getTrees_url() {
		return trees_url;
	}

	public String getHomepage() {
		return homepage;
	}

	@Override
	public String toString() {
		return "Repository{" +
			"id=" + id +
			", owner=" + owner +
			", name='" + name + '\'' +
			", full_name='" + full_name + '\'' +
			", description='" + description + '\'' +
			", fork=" + fork +
			", Private=" + Private +
			", languages=" + languages +
			", forkCount=" + forkCount +
			", stargazers_count=" + stargazers_count +
			", watchers_count=" + watchers_count +
			", size=" + size +
			", defaultBranch='" + defaultBranch + '\'' +
			", open_issue_count=" + open_issue_count +
			", has_issues=" + has_issues +
			", has_wiki=" + has_wiki +
			", has_pages=" + has_pages +
			", has_downloads=" + has_downloads +
			", pushed_at=" + pushed_at +
			", created_at=" + created_at +
			", updated_at=" + updated_at +
			", permissions=" + permissions +
			", url='" + url + '\'' +
			", html_url='" + html_url + '\'' +
			", archive_url='" + archive_url + '\'' +
			", assignees_url='" + assignees_url + '\'' +
			", blobs_url='" + blobs_url + '\'' +
			", branches_url='" + branches_url + '\'' +
			", clone_url='" + clone_url + '\'' +
			", collaborators_url='" + collaborators_url + '\'' +
			", comments_url='" + comments_url + '\'' +
			", commits_url='" + commits_url + '\'' +
			", compare_url='" + compare_url + '\'' +
			", contents_url='" + contents_url + '\'' +
			", contributors_url='" + contributors_url + '\'' +
			", deployments_url='" + deployments_url + '\'' +
			", downloads_url='" + downloads_url + '\'' +
			", events_url='" + events_url + '\'' +
			", forks_url='" + forks_url + '\'' +
			", git_commits_url='" + git_commits_url + '\'' +
			", git_refs_url='" + git_refs_url + '\'' +
			", git_tags_url='" + git_tags_url + '\'' +
			", git_url='" + git_url + '\'' +
			", hooks_url='" + hooks_url + '\'' +
			", issue_comment_url='" + issue_comment_url + '\'' +
			", issue_events_url='" + issue_events_url + '\'' +
			", issues_url='" + issues_url + '\'' +
			", keys_url='" + keys_url + '\'' +
			", labels_url='" + labels_url + '\'' +
			", languages_url='" + languages_url + '\'' +
			", merges_url='" + merges_url + '\'' +
			", milestones_url='" + milestones_url + '\'' +
			", mirror_url='" + mirror_url + '\'' +
			", notifications_url='" + notifications_url + '\'' +
			", pulls_url='" + pulls_url + '\'' +
			", releases_url='" + releases_url + '\'' +
			", ssh_url='" + ssh_url + '\'' +
			", stargazers_url='" + stargazers_url + '\'' +
			", statuses_url='" + statuses_url + '\'' +
			", subscribers_url='" + subscribers_url + '\'' +
			", subscription_url='" + subscription_url + '\'' +
			", svn_url='" + svn_url + '\'' +
			", tags_url='" + tags_url + '\'' +
			", teams_url='" + teams_url + '\'' +
			", trees_url='" + trees_url + '\'' +
			", homepage='" + homepage + '\'' +
			'}';
	}
}


