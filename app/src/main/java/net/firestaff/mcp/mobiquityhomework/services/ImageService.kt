package net.firestaff.mcp.mobiquityhomework.services

import net.firestaff.mcp.mobiquityhomework.data.AWS_BASE_URL

fun transformImageUrl(url: String): String {
    return AWS_BASE_URL + url
}