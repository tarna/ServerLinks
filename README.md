# ServerLinks
A Spigot 1.21 Plugin that allows servers to use the new server links features.

## Config
The config is simple and uses the key as the label and the value as the link.
```yml
Website: "https://domain.com"
Discord: "https://discord.gg/invite"
```

It also supports colors by using either the & or § symbol in the label.
```yml
§cWebsite: "https://domain.com"
```

## Commands
- `/serverlinks reload` - Reloads the config file with the new links. Player must relog to see changes.