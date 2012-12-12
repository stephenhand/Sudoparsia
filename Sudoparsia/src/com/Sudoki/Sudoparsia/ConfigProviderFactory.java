package com.Sudoki.Sudoparsia;

import com.Sudoki.Sudoparsia.config.HardCodedConfigProvider;
import com.Sudoki.Sudoparsia.config.IConfigProvider;

public class ConfigProviderFactory {
	public static IConfigProvider Build()
	{
		return new HardCodedConfigProvider();
	}
}
