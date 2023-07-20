package de.zeroco.util;

import java.util.regex.Pattern;

public class ManipulicationInQuery {

	public static void main(String[] args) {
		String query = "SELECT SQL_CALC_FOUND_ROWS\r\n" + 
				"    m.pk_id `uid`, \r\n" + 
				"    m.deleted_status `deleted_status`, \r\n" + 
				"    m.facility_amount `facility_amount`, \r\n" + 
				"        m.outstanding_amount `outstanding_amount.zc_double`, \r\n" + 
				"    m.project_id `project_id`, \r\n" + 
				"    m.title `title`, \r\n" + 
				"    m.created_time `created_time.zc_timestamp`, \r\n" + 
				"    mr1.pk_id `facility_amount_currency.uid`, \r\n" + 
				"        mr1.code `facility_amount_currency.code`, \r\n" + 
				"        mr1.icon `facility_amount_currency.icon`, \r\n" + 
				"        mr1.name `facility_amount_currency.name`, \r\n" + 
				"    mr2.pk_id `sector_one.uid`, \r\n" + 
				"        mr2.name `sector_one.name`, \r\n" + 
				"    mr3.pk_id `project_company.uid`, \r\n" + 
				"        mr3.is_primary `project_company.is_primary`, \r\n" + 
				"    mr3r4.pk_id `project_company.company.uid`, \r\n" + 
				"        mr3r4.name `project_company.company.name`, \r\n" + 
				"    mr5.pk_id `status.uid`, \r\n" + 
				"        mr5.background_color `status.background_color`, \r\n" + 
				"        mr5.code `status.code`, \r\n" + 
				"        mr5.icon `status.icon`, \r\n" + 
				"        mr5.name `status.name`, \r\n" + 
				"        mr5.text_color `status.text_color`, \r\n" + 
				"    mr6.pk_id `stage.uid`, \r\n" + 
				"        mr6.background_color `stage.background_color`, \r\n" + 
				"        mr6.code `stage.code`, \r\n" + 
				"        mr6.icon `stage.icon`, \r\n" + 
				"        mr6.name `stage.name`, \r\n" + 
				"        mr6.text_color `stage.text_color`\r\n" + 
				"FROM \r\n" + 
				"    `project` m         \r\n" + 
				"	LEFT JOIN `currency_master` mr1 ON mr1.pk_id  = m.facility_amount_currency AND  IFNULL(mr1.`is_deleted`, 0) = 0   \r\n" + 
				"     \r\n" + 
				"	LEFT JOIN `sector_one` mr2 ON mr2.pk_id  = m.sector_one AND  IFNULL(2.`is_deleted`, 0) = 0         \r\n" + 
				"	JOIN `project_company` mr3 ON mr3.project = m.pk_id  AND  IFNULL(mr3.`is_deleted`, 0) = 0  AND mr3.is_primary =  ? \r\n" + 
				" 	JOIN `company` mr3r4 ON mr3r4.pk_id  = mr3.company AND  IFNULL(mr3r4.`is_deleted`, 0) = 0         \r\n" + 
				"	JOIN `project_status` mr5 ON mr5.pk_id  = m.status AND  IFNULL(mr5.`is_deleted`, 0) = 0         \r\n" + 
				"	JOIN `project_stage` mr6 ON mr6.pk_id  = m.stage AND  IFNULL(f.`is_deleted`, 0) = 0 \r\n" + 
				"WHERE       IFNULL(m.`is_deleted`, 0) = 0    AND IFNULL(m.deleted_status,'') IN ('0') AND  1=1  ORDER BY m.created_time DESC LIMIT ?,?;";
		System.out.println(removeConditionsFromQuery(query));

	}
	
	public static String removeConditionsFromQuery(String query) {
		query = query.replaceAll("(AND)?\\s*IFNULL\\(.*\\.\\`is_deleted\\`, 0\\) = 0", "");
		if (Pattern.compile("WHERE\\s*(AND | BETWEEN)").matcher(query).find()) {
			query = query.replaceAll("WHERE\\s*(AND | BETWEEN)", "WHERE ");
		} else if (Pattern.compile("WHERE\\s*(ORDER BY | HAVING | ;)").matcher(query).find()) {
			query = query.replace("WHERE", "");
		}
		return query;
	}
}
