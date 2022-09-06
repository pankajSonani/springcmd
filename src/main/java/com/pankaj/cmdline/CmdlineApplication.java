package com.pankaj.cmdline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CmdlineApplication implements ApplicationRunner {
	private static final Logger logger = LoggerFactory.getLogger(CmdlineApplication.class);

	final
	DataService dataService;

	public CmdlineApplication(DataService dataService) {
		this.dataService = dataService;
	}

	public static void main(String[] args0) {
		SpringApplication.run(CmdlineApplication.class, args0);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
		logger.info("Non Option Args: {}", args.getNonOptionArgs());
		logger.info("Option Names: {}", args.getOptionNames());

		for (String name : args.getNonOptionArgs()){
			logger.info("arg-" + name + "=" + args.getOptionValues(name));
			System.out.println(dataService.getMessage(name));
		}

		for (String name : args.getOptionNames()){
			logger.info("arg-" + name + "=" + args.getOptionValues(name));
			System.out.println(dataService.getMessage(name));
		}
	}

	// run with java -jar cmdline-0.0.1-SNAPSHOT.jar sai pankaj  - this is non arg
	// java -jar cmdline-0.0.1-SNAPSHOT.jar ram --cmd.prop.1="pankaj" --cmd.prop.2="sai"

}



