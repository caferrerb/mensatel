<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

if ( ! function_exists('add_css()'))
{
	function add_css($array_css)
	{
		$path_css = 'assets/css/';
		$css_ouput = '';
		foreach ($array_css as $key => $value) {
			$css_ouput .= link_tag($path_css.$value);
		}
	  	return $css_ouput;
	}
}

if ( ! function_exists('add_js()'))
{
	function add_js($array_js)
	{
		$path_js = 'assets/js/';
		$js_ouput = '';
		foreach ($array_js as $key => $value) {
			$js_ouput .= js_tag($path_js.$value);
		}
	  	return $js_ouput;
	}
}