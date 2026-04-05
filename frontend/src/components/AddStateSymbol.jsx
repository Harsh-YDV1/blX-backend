import { useState } from "react";

const API_BASE = import.meta.env.VITE_API_URL || "";

async function addStateSymbol(payload) {
  const response = await fetch(`${API_BASE}/api/state-symbols`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(payload),
  });

  if (!response.ok) {
    throw new Error(`Request failed with status ${response.status}`);
  }

  return response.json();
}

export default function AddStateSymbol({ onSuccess }) {
  const [stateName, setStateName] = useState("");
  const [symbolType, setSymbolType] = useState("");
  const [symbolName, setSymbolName] = useState("");
  const [imageUrl, setImageUrl] = useState("");
  const [description, setDescription] = useState("");
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(false);

  async function submitSymbol(e) {
    e.preventDefault();
    setError(null);
    setLoading(true);

    try {
      await addStateSymbol({
        name: symbolName,
        state: stateName,
        region: symbolType,
        image: imageUrl,
        description,
      });

      // Reset form on success
      setStateName("");
      setSymbolType("");
      setSymbolName("");
      setImageUrl("");
      setDescription("");

      if (onSuccess) onSuccess();
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  }

  return (
    <form onSubmit={submitSymbol}>
      <div>
        <label htmlFor="symbolName">Symbol Name</label>
        <input
          id="symbolName"
          type="text"
          value={symbolName}
          onChange={(e) => setSymbolName(e.target.value)}
          required
        />
      </div>

      <div>
        <label htmlFor="stateName">State</label>
        <input
          id="stateName"
          type="text"
          value={stateName}
          onChange={(e) => setStateName(e.target.value)}
          required
        />
      </div>

      <div>
        <label htmlFor="symbolType">Symbol Type</label>
        <input
          id="symbolType"
          type="text"
          value={symbolType}
          onChange={(e) => setSymbolType(e.target.value)}
          required
        />
      </div>

      <div>
        <label htmlFor="imageUrl">Image URL</label>
        <input
          id="imageUrl"
          type="url"
          value={imageUrl}
          onChange={(e) => setImageUrl(e.target.value)}
        />
      </div>

      <div>
        <label htmlFor="description">Description</label>
        <textarea
          id="description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
      </div>

      {error && <p style={{ color: "red" }}>{error}</p>}

      <button type="submit" disabled={loading}>
        {loading ? "Saving…" : "Add Symbol"}
      </button>
    </form>
  );
}
